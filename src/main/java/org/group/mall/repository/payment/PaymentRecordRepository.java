package org.group.mall.repository.payment;

import org.group.mall.model.payment.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord,Long> {

}
