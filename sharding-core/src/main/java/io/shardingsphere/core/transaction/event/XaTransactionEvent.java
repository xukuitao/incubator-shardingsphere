/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.transaction.event;

import com.google.common.base.Optional;
import io.shardingsphere.core.exception.ShardingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * XA transactionEvent.
 *
 * @author zhaojun
 */
@RequiredArgsConstructor
@Getter
public class XaTransactionEvent extends TransactionEvent {
    
    private final String sql;
    
    /**
     * Get exception.
     *
     * @return exception
     */
    public Optional<ShardingException> getException() {
        Optional<? extends Exception> ex = super.getException();
        if (ex.isPresent()) {
            return Optional.of((ShardingException) ex.get());
        }
        return Optional.absent();
    }
}
