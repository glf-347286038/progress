package com.annotation.import01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lfgao
 */
@Configuration
@Import({GeneralClassA.class, SelfImportSelector.class, SelfImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
