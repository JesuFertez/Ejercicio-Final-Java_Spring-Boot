package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.PlanPresenter;
import com.jesucompany.ejerciciospringboot.presenter.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanRestController {

    private final PlanPresenter planPresenter;

    public PlanRestController(PlanPresenter planPresenter) {
        this.planPresenter = planPresenter;
    }

    @GetMapping
    public List<PlanDTO>getAllPlans() {
        return planPresenter.getPlansForView();
    }

    @GetMapping("/{id}")
    public PlanDTO getPlanById(@PathVariable("id") Long id) {
        return planPresenter.getPlanById(id);
    }

    @PostMapping
    public PlanDTO createPlan(@RequestBody Plan plan) {
        return planPresenter.createPlan(plan.getName(),plan.getPrice(),
                plan.getServicesProvided(),plan.isActive());
    }

    @PutMapping("/{id}")
    public PlanDTO updatePlan(@PathVariable("id") Long id, @RequestBody Plan plan) {
        return planPresenter.updatePlan(id, plan);
    }

    @DeleteMapping("/id")
    public void deletePlan(@PathVariable("id") Long id) {
        planPresenter.deletePlan(id);
    }

}
