package com.jesucompany.ejerciciospringboot.presenter;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.PlanServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanPresenter {

        private final PlanServiceImpl planServiceImpl;

        public PlanPresenter(PlanServiceImpl planServiceImpl) {
            this.planServiceImpl = planServiceImpl;
        }

        public List<PlanDTO> getPlansForView() {
            try {
                return planServiceImpl.getAllPlans();
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los planes", e);
            }
        }

        public PlanDTO createPlan(String name, int price, String servicesProvided, boolean active) {
            if (name == null || price < 0) {
            throw new IllegalArgumentException("El nombre o el precio no pueden ser nulos ni negativos");
            }
            Plan plan = new Plan(name, price, servicesProvided, active);
            return planServiceImpl.createPlan(plan);
        }


    public PlanDTO getPlanById(Long id) {
            PlanDTO plan = planServiceImpl.getPlanById(id);
            return plan;
    }

    public void deletePlan(Long id) {
            planServiceImpl.deletePlan(id);
    }

    public PlanDTO updatePlan(Long id, Plan plan) {
            PlanDTO planUpdate = planServiceImpl.updatePlan(id,plan);
            return planUpdate;
    }
}
