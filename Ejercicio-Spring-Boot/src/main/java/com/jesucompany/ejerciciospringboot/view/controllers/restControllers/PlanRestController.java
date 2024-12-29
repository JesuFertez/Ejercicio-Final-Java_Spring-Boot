package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.PlanPresenter;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PlanDTO>> getAllPlans() {
        List<PlanDTO> plans = planPresenter.getPlansForView();
        if (plans.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content si no hay planes
        }
        return ResponseEntity.ok(plans); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> getPlanById(@PathVariable("id") Long id) {
        try {
            PlanDTO planDTO = planPresenter.getPlanById(id);
            return ResponseEntity.ok(planDTO); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }

    @PostMapping
    public ResponseEntity<PlanDTO> createPlan(@RequestBody Plan plan) {
        try {
            PlanDTO planDTO = planPresenter.createPlan(plan.getName(), plan.getPrice(),
                    plan.getServicesProvided(), plan.isActive());
            return ResponseEntity.status(HttpStatus.CREATED).body(planDTO); //201 Created
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanDTO> updatePlan(@PathVariable("id") Long id, @RequestBody Plan plan) {
        try {
            PlanDTO planDTO = planPresenter.updatePlan(id, plan);
            return ResponseEntity.ok(planDTO); //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //404 Not Found
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletePlan(@PathVariable("id") Long id) {
        try {
            planPresenter.deletePlan(id);
            return ResponseEntity.noContent().build(); //204 No Content
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404 Not Found
        }
    }
}
