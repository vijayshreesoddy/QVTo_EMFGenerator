#!/bin/bash
echo "Generating Model from VSConfig" 
java -jar viatraExecutor.jar sample.vsconfig
echo "Model is generated" 
exit $?

