package com.design.pattern.strategy;

import com.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author golf
 * @date 2023/9/26 14:51
 */
@Slf4j
@Service
public class PaymentStrategyContext {

    /**
     * 策略实现类工厂map
     */
    private static final Map<PaymentEnum, PaymentStrategy> PAYMENT_STRATEGY_MAP = new EnumMap<>(PaymentEnum.class);

    /**
     * 注入策略实现类
     *
     * @param paymentEnum     策略类型
     * @param paymentStrategy 策略实现类
     */
    public static void putStrategy(PaymentEnum paymentEnum, PaymentStrategy paymentStrategy) {
        if (PAYMENT_STRATEGY_MAP.get(paymentEnum) != null) {
            throw new ServiceException(paymentEnum + ":重复注入");
        }
        PAYMENT_STRATEGY_MAP.put(paymentEnum, paymentStrategy);
    }

    /**
     * 获取具体策略实现
     *
     * @param paymentEnum 策略类型
     * @return 策略实现
     */
    public PaymentStrategy getPaymentStrategy(PaymentEnum paymentEnum) {
        return Optional.ofNullable(PAYMENT_STRATEGY_MAP.get(paymentEnum)).orElseThrow(() -> {
            log.error("{}:未找到对应的策略实现类", paymentEnum);
            return new ServiceException("未知的类型");
        });
    }
}
