package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RequestController {

    private RequestService requestService;
    @Autowired
    RequestController(RequestService rS) {
        this.requestService = rS;
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/save/request",
            produces = "application/json",
            method = RequestMethod.POST
    )
    public void saveRequest(
            @Valid @RequestBody Request request,
            Error errors) {
        requestService.insert(request);
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/get/{id}/",
            method = RequestMethod.POST
    )
    public Request getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/update/{id}/",
            method = RequestMethod.POST
    )
    public void updateRequest(@PathVariable Long id) {
        requestService.getRequestById(id);
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/delete/{id}/",
            method = RequestMethod.POST
    )
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/{id}/confirm/start/{time}/",
            method = RequestMethod.POST
    )
    public void confirmStart(@PathVariable Long id, @PathVariable LocalDateTime time) {
        requestService.confirmStart(id, time);
    }

    @ResponseBody
    @RequestMapping(
            value = "/requests/{id}/confirm/end/{time}/",
            method = RequestMethod.POST
    )
    public void confirmEnd(@PathVariable Long id, @PathVariable LocalDateTime time) {
        requestService.confirmEnd(id, time);
    }
}