#!/usr/bin/env bash

# ./create_flyway_migration.sh "descrição"
DESCRIPTION="$1"

if [ -z "$DESCRIPTION" ]; then
  exit 1
fi

TIMESTAMP=$(date +"%Y%m%d%H%M%S")

SAFE_DESCRIPTION="${DESCRIPTION//[ \/]/_}"
SAFE_DESCRIPTION="${SAFE_DESCRIPTION//[^a-zA-Z0-9_-]/}"
FILENAME="V${TIMESTAMP}__${SAFE_DESCRIPTION}.sql"

mkdir -p src/main/resources/db/migration

cat <<EOL > "src/main/resources/db/migration/$FILENAME"
-- Migration: $DESCRIPTION
-- Created at $(date)
EOL