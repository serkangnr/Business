package com.businessapi.controller;


import com.businessapi.dto.request.EmployeeSaveRequestDTO;
import com.businessapi.dto.request.EmployeeUpdateRequestDTO;
import com.businessapi.dto.response.EmployeeResponseDTO;
import com.businessapi.dto.response.ResponseDTO;
import com.businessapi.entity.Employee;
import com.businessapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.businessapi.constants.EndPoints.*;

@RestController
@RequestMapping(EMPLOYEE)
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE})
public class EmployeeController {
    private  final EmployeeService employeeService;

    @PostMapping(SAVE)
    @Operation(summary = "Creates new Employee")
    public ResponseEntity<ResponseDTO<Boolean>> save(@RequestBody EmployeeSaveRequestDTO dto){

        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(employeeService.save(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(UPDATE)
    @Operation(summary = "Update Employee")
    public ResponseEntity<ResponseDTO<Boolean>> update(@RequestBody EmployeeUpdateRequestDTO dto){

        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(employeeService.update(dto))
                .message("Success")
                .code(200)
                .build());
    }
    @GetMapping (FIND_BY_ID)
    @Operation(summary = "Find employee by id")
    public ResponseEntity<ResponseDTO<EmployeeResponseDTO>> findById(@RequestParam Long id){

        return ResponseEntity.ok(ResponseDTO
                .<EmployeeResponseDTO>builder()
                .data(employeeService.findById(id))
                .message("Success")
                .code(200)
                .build());
    }
    @GetMapping (FIND_ALL)
    @Operation(summary = "Find all employee ")
    public ResponseEntity<ResponseDTO<List<EmployeeResponseDTO>>> findAll(){

        return ResponseEntity.ok(ResponseDTO
                .<List<EmployeeResponseDTO>>builder()
                .data(employeeService.findAll())
                .message("Success")
                .code(200)
                .build());
    }
    @DeleteMapping(DELETE)
    @Operation(summary = "Delete employee by id")
    public ResponseEntity<ResponseDTO<Boolean>> delete(@RequestParam Long id){
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(employeeService.delete(id))
                .message("Success")
                .code(200)
                .build());
    }

}
