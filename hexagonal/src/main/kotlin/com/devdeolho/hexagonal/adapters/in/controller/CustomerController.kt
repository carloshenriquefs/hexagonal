package com.devdeolho.hexagonal.adapters.`in`.controller

import com.devdeolho.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.devdeolho.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.devdeolho.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
        private val insertCustomerInputPort: InsertCustomerInputPort,
        private val findCustomerByIdInputPort: FindCustomerByIdInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }
}
