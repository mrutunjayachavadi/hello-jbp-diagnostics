# hello-jbp-diagnostics
Example Java web app to test https://github.com/lhotari/java-buildpack-diagnostics-app on CloudFoundry

## Deploying app
```
cp manifest.yml.template manifest.yml
$EDITOR manifest.yml
cf push
```

## Testing heapdumps

see https://github.com/lhotari/java-buildpack-diagnostics-app/blob/master/README.md#requesting-heap-dumps
