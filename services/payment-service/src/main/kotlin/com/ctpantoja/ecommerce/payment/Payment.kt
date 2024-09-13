package com.ctpantoja.ecommerce.payment

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "payment")
class Payment(

    @Id
    @GeneratedValue
    val id: Int,

    val amount: BigDecimal,

    @Enumerated(EnumType.STRING)
    val paymentMethod: PaymentMethod,

    val orderId: Int,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(insertable = false)
    var lastModifiedDate: LocalDateTime? = null,
) {
}