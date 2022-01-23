package ru.gb.lesson3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.lesson3.entity.Message;
import ru.gb.lesson3.service.MessageService;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    //метод создания формы
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "create-message";
    }


    //метод обработки формы и созранения в БД
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Message message){
        if (message.getId() == null) {
            messageService.save(message);
        } else {
            messageService.edit(message);
        }
        return "redirect:/message/all";
    }

    //метод вывода одного сообщения в браузер message/3?random=true|false
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom) {
        Message message = null;
        if (isRandom) {
            message = messageService.getRandomMessage();
        } else {
            message = messageService.findById(id);
        }
        model.addAttribute("message", message);
        return "message";
    }

    //метод вывода списка сообщений в браузер
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "message-list";
    }
    //метод удаления сообщения из хранилища
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id) {
        messageService.deleteById(id);
        return "redirect:/message/all";
    }

    //метод редактирования
    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "create-message";
    }
}
