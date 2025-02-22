package com.businessapi.controllers;

import com.businessapi.dto.request.BudgetSaveRequestDTO;
import com.businessapi.dto.request.BudgetUpdateRequestDTO;
import com.businessapi.dto.request.PageRequestDTO;
import com.businessapi.dto.response.ResponseDTO;
import com.businessapi.entity.Budget;
import com.businessapi.services.BudgetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.businessapi.constants.Endpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT + BUDGET)
@CrossOrigin("*")
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping(SAVE)
    @Operation(summary = "Saves new budget")
    public ResponseEntity<ResponseDTO<Boolean>> save(BudgetSaveRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(budgetService.save(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Updates an existing budget")
    public ResponseEntity<ResponseDTO<Boolean>> update(BudgetUpdateRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(budgetService.update(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Deletes an existing budget")
    public ResponseEntity<ResponseDTO<Boolean>> delete(Long id) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(budgetService.delete(id))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_ALL)
    @Operation(summary = "Lists all the budgets with respect to the given page and size")
    public ResponseEntity<ResponseDTO<List<Budget>>> findAll(@RequestBody PageRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<List<Budget>>builder()
                .data(budgetService.findAll(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_BY_ID)
    @Operation(summary = "Finds a budget by its id")
    public ResponseEntity<ResponseDTO<Budget>> findById(Long id) {
        return ResponseEntity.ok(ResponseDTO
                .<Budget>builder()
                .data(budgetService.findById(id))
                .message("Success")
                .code(200)
                .build());
    }
}