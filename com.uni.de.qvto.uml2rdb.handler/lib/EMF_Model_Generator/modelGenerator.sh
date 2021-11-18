#!/bin/bash
echo "Generating VS Config File" 
java -jar vsconfigGenerator.jar configuration.properties
echo "Generating Model from VSConfig" 
java -jar viatraExecutor.jar sample.vsconfig
echo "Model is generated" 
exit $?

