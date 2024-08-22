package com.devdeolho.hexagonal.adapters.`in`.consumer

import com.devdeolho.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.devdeolho.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidateCustomerDataConsumer(
        private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "devdeolho")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }

}
