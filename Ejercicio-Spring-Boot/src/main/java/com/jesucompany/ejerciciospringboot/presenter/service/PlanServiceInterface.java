package com.jesucompany.ejerciciospringboot.presenter.service;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;

import java.util.List;

public interface PlanServiceInterface {

        List<PlanDTO> getAllPlans();
        PlanDTO getPlanById(Long id);
        PlanDTO createPlan(Plan plan);
        PlanDTO updatePlan(Long id, Plan planUpdate);
        void deletePlan(Long id);
}
