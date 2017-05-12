# role-based-auth-api

A compojure-api sample utilizing token-based authentication and role-guarded routes.

## Create the MySQL database for local development

Use `script/init_database.sql`

## Running Locally

`lein ring server-headless`

Then visit [http://localhost:3000/api/v1/docs/index.html](http://localhost:3000/api/v1/docs/index.html)

## Try API!

Available users: `user:password`, `admin:password`, `poweruser:password`

1. Get token via [http://localhost:3000/api/v1/docs/index.html#!/auth/post_api_v1_login](http://localhost:3000/api/v1/docs/index.html#!/auth/post_api_v1_login)

2. Click 'Authorize' swagger button and enter `Token [your_token]`

3. Check routes that require specific role
