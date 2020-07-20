# digdag-extension-example

A [Digdag extension](https://docs.digdag.io/internal.html#extension) example.

## Run a workflow with ExampleExtension

```
$ sbt publishLocal
$ java -cp $(which digdag):target/scala-2.13/digdag-extension-example_2.13-0.1.0-SNAPSHOT.jar \
  io.digdag.cli.Main run --no-save example.dig --config digdag.properties
```

```
2020-07-20 20:26:24 +0900: Digdag v0.9.41
2020-07-20 20:26:26 +0900 [WARN] (main): Using a new session time 2020-07-20T00:00:00+00:00.
2020-07-20 20:26:26 +0900 [INFO] (main): Starting a new session project id=1 workflow name=example session_time=2020-07-20T00:00:00+00:00
2020-07-20 20:26:27 +0900 [INFO] (0017@[0:default]+example+oops): fail>: Oops!!!
2020-07-20 20:26:27 +0900 [ERROR] (0017@[0:default]+example+oops): Task +example+oops failed.
Oops!!!
2020-07-20 20:26:28 +0900 [INFO] (0017@[0:default]+example^failure-alert): type: notify
2020-07-20 20:26:28 +0900 [INFO] (0017@[0:default]+example^failure-alert): ========== ExampleNotificationSender ==========
2020-07-20 20:26:28 +0900 [INFO] (0017@[0:default]+example^failure-alert): Notification{timestamp=2020-07-20T11:26:28.154Z, message=Workflow session attempt failed, siteId=0, projectId=1, projectName=default, workflowName=example, revision=2020-07-20T11:26:26.466Z, attemptId=1, sessionId=1, taskName=+example^failure-alert, timeZone=UTC, sessionUuid=b3ceed18-aeed-4b75-8e1c-f9124b13d34b, sessionTime=2020-07-20T00:00Z}
2020-07-20 20:26:28 +0900 [INFO] (0017@[0:default]+example^failure-alert): ===============================================
error:
  * +example+oops:
    Oops!!!
```
