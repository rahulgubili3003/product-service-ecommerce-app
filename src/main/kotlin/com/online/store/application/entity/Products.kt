package com.online.store.application.entity

import com.online.store.application.enums.Category
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class Products(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null,

    @Column(name = "product_name", nullable = false)
    @NotBlank(message = "Product Name is Required")
    val productName: String,

    @Column(name = "product_desc", nullable = false)
    @NotBlank(message = "Product Desc is Required")
    val description: String,

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    val category: Category,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "inventory_id")
    val inventory: ProductInventory,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date? = null,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
)
