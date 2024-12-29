package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.PlanPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


class PlanRestControllerTest {

    // Mock configuration
    PlanPresenter planPresenter = mock(PlanPresenter.class);
    PlanRestController planRestController = new PlanRestController(planPresenter);

    private String planName;
    private int planPrice;
    private String planServicesProvided;
    private boolean planActive;
    private Long planId;

    @BeforeEach
    void setUp() {
        planName = "Basic Plan";
        planPrice = 1000;
        planServicesProvided = "Streaming, Download";
        planActive = true;
        planId = 1L;
    }

    @Test
    void getAllPlans() {
        // Mock configuration
        when(planPresenter.getPlansForView()).thenReturn(List.of(
                new PlanDTO(planId.toString(), planName, planPrice, planServicesProvided, planActive, List.of())
        ));
        ResponseEntity<List<PlanDTO>> response = planRestController.getAllPlans();

        // Assertions
        assertNotNull(response, "Response should not be null"); // Verifica que la respuesta no sea null
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be 200 OK"); // Verifica el estado HTTP
        assertNotNull(response.getBody(), "Response body should not be null"); // Verifica que el cuerpo no sea null
        assertEquals(1, response.getBody().size(), "The list should contain exactly one plan"); // Verifica el tamaño de la lista

        PlanDTO plan = response.getBody().get(0);
        assertEquals(planName, plan.getName(), "The plan name should match the expected value");
        assertEquals(planPrice, plan.getPrice(), "The plan price should match the expected value");
        assertEquals(planServicesProvided, plan.getServicesProvided(), "The plan services should match the expected value");
        assertEquals(planActive, plan.isActive(), "The plan active status should match the expected value");
    }


    @Test
    void createPlan() {

        when(planPresenter.createPlan(planName, planPrice, planServicesProvided, planActive)).thenReturn(
                new PlanDTO(planId.toString(), planName, planPrice, planServicesProvided, planActive, List.of()));

        Plan plan = new Plan(planName, planPrice, planServicesProvided, planActive);
        // Call the method
        ResponseEntity<PlanDTO> response = planRestController.createPlan(plan);
        //Assertions
        assertNotNull(response, "Response should not be null");
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Response status should be 201 Created");
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(planId.toString(), response.getBody().getId(), "The plan id should match the expected value");
        assertEquals(planName, response.getBody().getName(), "The plan name should match the expected value");
    }

    @Test
    void getPlanByID() {
        when(planPresenter.getPlanById(planId)).thenReturn(
                new PlanDTO(planId.toString(), planName, planPrice, planServicesProvided, planActive, List.of()));

        ResponseEntity<PlanDTO> response = planRestController.getPlanById(planId);
        assertNotNull(response, "Response should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be 200 OK");
        assertEquals(planId.toString(), response.getBody().getId(), "The plan id should match the expected value");
        assertEquals(planName, response.getBody().getName(), "The plan name should match the expected value");
    }

    @Test
    void updatePlan() {
        planPrice = 4000;
        planActive = false;

        when(planPresenter.updatePlan(planId, new Plan(planName, planPrice, planServicesProvided, planActive))).thenReturn(
                new PlanDTO(planId.toString(), planName, planPrice, planServicesProvided, planActive, List.of()));

        ResponseEntity<PlanDTO> response = planRestController.updatePlan(planId, new Plan(planName, planPrice, planServicesProvided, planActive));

        assertNotNull(response, "Response should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be 200 OK");
        assertEquals(planPrice, response.getBody().getPrice(), "The plan price should match the expected value");
        assertEquals(planActive, response.getBody().isActive(), "The plan active status should match the expected value");
    }

    @Test
    void deletePlan() {
        // Arrange: Configurar el mock para que deletePlan no haga nada
        doNothing().when(planPresenter).deletePlan(planId);

        ResponseEntity<Void> response = planRestController.deletePlan(planId);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        // Verificar que deletePlan fue llamado exactamente una vez con el argumento esperado
        verify(planPresenter, times(1)).deletePlan(planId);
    }
}





