package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderRequest;
import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderUpdate;
import com.example.motorbike_be.dto.invoice.response.order.InvoiceOrderResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.InvoiceOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/invoice-order")
@RequiredArgsConstructor
@Tag(name = "Invoice Order API", description = "Invoice Order API")
public class InvoiceOrderController {

    private final InvoiceOrderService invoiceOrderService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<InvoiceOrderResponse>>> getAll(){
        List<InvoiceOrderResponse> responses = invoiceOrderService.getAllInvoiceOrders();
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Invoice Order Successful",
                        responses,
                        ""
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceOrderResponse>> getById(@PathVariable String id){
        InvoiceOrderResponse response = invoiceOrderService.getInvoiceOrderById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Invoice Order By Id Successful",
                        response,
                        ""
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceOrderResponse>> update(@PathVariable String id,@RequestBody InvoiceOrderUpdate request){
        InvoiceOrderResponse response = invoiceOrderService.updateInvoiceOrder(id, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Invoice Order Successful",
                        response,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InvoiceOrderResponse>> create (@Valid @RequestBody InvoiceOrderRequest request){
        InvoiceOrderResponse response = invoiceOrderService.createInvoiceOrder(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create Invoice Order Successful",
                        response,
                        ""
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        invoiceOrderService.deleteInvoiceOrder(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Invoice Order Successful"
                )
        );
    }
}
