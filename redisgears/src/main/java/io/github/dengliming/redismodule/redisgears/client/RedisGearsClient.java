/*
 * Copyright 2021 dengliming.
 *
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
 */

package io.github.dengliming.redismodule.redisgears.client;

import io.github.dengliming.redismodule.redisgears.RedisGears;
import org.redisson.Redisson;
import org.redisson.client.protocol.RedisCommands;
import org.redisson.command.CommandAsyncExecutor;
import org.redisson.config.Config;

public class RedisGearsClient extends Redisson {

    public RedisGearsClient(Config config) {
        super(config);
    }

    public RedisGears getRedisGears() {
        return new RedisGears(getCommandExecutor());
    }

    public Void flushall() {
        CommandAsyncExecutor commandExecutor = getCommandExecutor();
        return commandExecutor.get(commandExecutor.writeAllAsync(RedisCommands.FLUSHALL));
    }
}
