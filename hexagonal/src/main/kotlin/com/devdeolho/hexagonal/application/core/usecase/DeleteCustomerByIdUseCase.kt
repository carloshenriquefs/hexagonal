package com.devdeolho.hexagonal.application.core.usecase

import com.devdeolho.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.devdeolho.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.devdeolho.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
        private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
        private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}
