package com.businessapi.controllers;

import com.businessapi.dto.request.PageRequestDTO;
import com.businessapi.dto.request.StockMovementSaveDTO;
import com.businessapi.dto.request.StockMovementUpdateRequestDTO;
import com.businessapi.dto.response.ResponseDTO;
import com.businessapi.dto.response.StockMovementResponseDTO;
import com.businessapi.entities.StockMovement;
import com.businessapi.services.StockMovementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.businessapi.constants.Endpoints.*;

@RestController
@RequestMapping(ROOT + STOCKMOVEMENT)
@RequiredArgsConstructor
@CrossOrigin("*")
public class StockMovementController
{
    private final StockMovementService stockMovementService;

    @PostMapping(SAVE)
    @Operation(summary = "Creates new Stock Movement")
    public ResponseEntity<ResponseDTO<Boolean>> save(@RequestBody StockMovementSaveDTO dto){

        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(stockMovementService.save(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Soft deletes Stock Movement")
    public ResponseEntity<ResponseDTO<Boolean>> delete(Long id){

        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(stockMovementService.delete(id))
                .message("Success")
                .code(200)
                .build());
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Updates Stock Movement")
    public ResponseEntity<ResponseDTO<Boolean>> update(@RequestBody StockMovementUpdateRequestDTO dto){

        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(stockMovementService.update(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_ALL)
    @Operation(summary = "Finds all Stock Movements with respect to pagination")
    public ResponseEntity<ResponseDTO<List<StockMovementResponseDTO>>> findAll(@RequestBody PageRequestDTO dto){

        return ResponseEntity.ok(ResponseDTO
                .<List<StockMovementResponseDTO>>builder()
                .data(stockMovementService.findAll(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_BY_ID)
    @Operation(summary = "Finds Stock Movement by Id")
    public ResponseEntity<ResponseDTO<StockMovement>> findById(Long id){

        return ResponseEntity.ok(ResponseDTO
                .<StockMovement>builder()
                .data(stockMovementService.findById(id))
                .message("Success")
                .code(200)
                .build());
    }
}
