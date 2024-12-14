package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/web-plans")
public class PlanWebController {
    private final PlanService planService;

    public PlanWebController(PlanService planService){
        this.planService = planService;
    }

    @GetMapping
    public String getAllPlans(Model model){
        List<PlanDTO> plans = planService.getAllPlans();
        model.addAttribute("plans",plans);
        return "web-plans";
    }

    @GetMapping("/create-plan")
    public String showFormPlan(Model model){
        model.addAttribute("plan", new Plan());
        return "create-plan";
    }

    @PostMapping("/save")
    public String createPlan(
            @RequestParam String name,
            @RequestParam int price,
            @RequestParam String servicesProvided,
            @RequestParam boolean active,
            RedirectAttributes redirectAttributes){
            Plan plan = new Plan(name, price, servicesProvided, active);
        try{
            planService.createPlan(plan);
            redirectAttributes.addFlashAttribute("message","Plan creado exitosamente");
        }catch (IllegalStateException| IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/web-plans";
    }
}
