#!/usr/bin/env sh
# -*- encoding UTF-8 -*-
# Author: Johny

# TINGYUN
# Env
TINGHYUN_PATH=$PROJECT_PATH/tingyun/tingyun.properties

# only set VERSION if not set
[ -z "$TINGYUN_ENABLED" ] && TINGYUN_ENABLED=false

# Config
sed -i "s/nbs.agent_enabled=TINGYUN_ENABLED/nbs.agent_enabled=$TINGYUN_ENABLED/g"  $TINGHYUN_PATH
sed -i "s/nbs.license_key=TINGYUN_LICENSE_KEY/nbs.license_key=$TINGYUN_LICENSE_KEY/g"   $TINGHYUN_PATH
sed -i "s/nbs.app_name=TINGYUN_APP_NAME/nbs.app_name=$TINGYUN_APP_NAME/g"   $TINGHYUN_PATH



# ARMS
# Env
ARMS_PATH=$PROJECT_PATH/armsagent/arms-agent.config

# only set VERSION if not set
[ -z "$ARMS_ENABLE" ] && ARMS_ENABLED=false
[ -z "$SAMPLING_ENABLE" ] && SAMPLING_ENABLE=false

# Config
sed -i "s/profiler.enable=ARMS_ENABLE/profiler.enable=$ARMS_ENABLE/g"  $ARMS_PATH
sed -i "s/arms.licenseKey=ARMS_LICENSE_KEY/arms.licenseKey=$ARMS_LICENSE_KEY/g"   $ARMS_PATH
sed -i "s/arms.appId=ARMS_APP_ID/arms.appId=$ARMS_APP_ID/g"   $ARMS_PATH
sed -i "s/profiler.sampling.enable=SAMPLING_ENABLE/profiler.sampling.enable=$SAMPLING_ENABLE/g"   $ARMS_PATH
sed -i "s/profiler.sampling.rate=SAMPLING_RATE/profiler.sampling.rate=$SAMPLING_RATE/g"   $ARMS_PATH
