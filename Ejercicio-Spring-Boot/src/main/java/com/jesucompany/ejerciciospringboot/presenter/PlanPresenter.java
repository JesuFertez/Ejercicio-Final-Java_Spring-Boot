package com.jesucompany.ejerciciospringboot.presenter;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.PlanService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanPresenter {

        private final PlanService planService;

        public PlanPresenter(PlanService planService) {
            this.planService = planService;
        }

        public List<PlanDTO> getPlansForView() {
            try {
                return planService.getAllPlans();
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los planes", e);
            }
        }

        public PlanDTO createPlan(String name, int price, String servicesProvided, boolean active) {
            Plan plan = new Plan(name, price, servicesProvided, active);
            return planService.createPlan(plan);
        }


    public PlanDTO getPlanById(Long id) {
            PlanDTO plan = planService.getPlanById(id);
            return plan;
    }

    public void deletePlan(Long id) {
            planService.deletePlan(id);
    }

    public PlanDTO updatePlan(Long id, Plan plan) {
            PlanDTO planUpdate = planService.updatePlan(id,plan);
            return planUpdate;
    }
}
