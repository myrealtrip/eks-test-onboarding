package com.myrealtrip.skeleton.infrastructure.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * TransactionRoutingDataSource
 *
 * @author sarasu
 * @since 2021.11.09
 */
public class TransactionRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly() == true) {
            return TransactionType.READ_ONLY;
        }

        return TransactionType.READ_WRITE;
    }
}
