package com.ctpantoja.ecommerce.order

import com.ctpantoja.ecommerce.orderline.OrderLine
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "customer_order")
data class Order(

    @GeneratedValue
    @Id
    val id: Int,

    @Column(unique = true,  nullable = false)
    var reference: String? = null,

    var totalAmount: BigDecimal? = null,

    @Enumerated(EnumType.STRING)
    var paymentMethod: PaymentMethod? = null,

    var customerId: String? = null,

    @OneToMany(mappedBy = "order")
    var orderLines: List<OrderLine>? = mutableListOf(),

    @CreatedDate
    @Column(updatable = false, nullable = false)
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(insertable = false)
    var lastModifiedDate: LocalDateTime? = null,
)
