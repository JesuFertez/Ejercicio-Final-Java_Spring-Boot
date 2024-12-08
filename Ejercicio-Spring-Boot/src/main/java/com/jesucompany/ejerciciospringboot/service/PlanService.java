package com.jesucompany.ejerciciospringboot.service;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.repository.PlansRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PlanService {
    private final PlansRepository plansRepository;
    private ModelMapper modelMapper;
    public PlanService(PlansRepository plansRepository) {
        this.plansRepository = plansRepository;
    }

    public List<PlanDTO> getAllPlans() {
        List<Plan> plans = plansRepository.findAll();
        List<PlanDTO> planDTOs = new ArrayList<>();
        for (Plan plan : plans) {
            PlanDTO planDTO = new PlanDTO();
        }
        return planDTOs;
    }

    public PlanDTO getPlanById(Long id) {
       Plan plan = plansRepository.findById(id).orElse(null);
       PlanDTO planDTO = modelMapper.map(plan, PlanDTO.class);
        return planDTO;
    }

    public PlanDTO createPlan(Plan plan) {
        PlanDTO planDTO = modelMapper.map(plansRepository.save(plan), PlanDTO.class);
        return planDTO;
    }

    public PlanDTO updatePlan(Long id, Plan planUpdate) {
        Plan plan = plansRepository.findById(id).orElse(null);
        plan.setName(planUpdate.getName());
        plan.setPrice(planUpdate.getPrice());
        plansRepository.save(plan);
        PlanDTO planDTO = modelMapper.map(plan, PlanDTO.class);
        return  planDTO;
    }

    public void deletePlan(Long id) {
        plansRepository.deleteById(id);
    }
}
