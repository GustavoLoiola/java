package com.easyconvert.service.conversion.conversion;

import com.easyconvert.entity.ConversionType;
import com.easyconvert.exception.InvalidFileTypeException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ConversionStrategyFactory {

    private final Map<ConversionType, ConversionStrategy> strategies;

    public ConversionStrategyFactory(List<ConversionStrategy> availableStrategies) {
        this.strategies = availableStrategies.stream()
                .collect(Collectors.toMap(ConversionStrategy::getType, Function.identity()));
    }

    public ConversionStrategy getStrategy(ConversionType type) {
        ConversionStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new InvalidFileTypeException("Nenhuma estrategia de conversao disponivel para o tipo: " + type);
        }
        return strategy;
    }
}