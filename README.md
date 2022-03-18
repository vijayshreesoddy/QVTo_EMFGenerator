# QVToProfiler
## Pre-Requisite
Pre-Requisite to work with QVToProfiler Plugins
1. Download Eclipse modelling tool (https://www.eclipse.org/downloads/packages/release/2020-03/r/eclipse-modeling-tools)
2. JDK 1.8 should be installed 
3. Maven 3.6

##  Getting Projects from GIT
1. git clone -b master https://github.com/vijayshreesoddy/QVToProfiler.git
2. Import the checkout projects in eclipse. While importing please dont select "Search for nested projects" 
3. After clicking on finish, you will have projects imported in your eclipse workspace

##  Download the Input files
1. Download the input files located in QVToProfiler/com.uni.de.qvto.feature/rootfiles/QVTo/ to your local system (For Ex: C:/temp/)

##  Setting the Target definition
1. Target definition is located in QVToProfiler\com.uni.de.qvto.target\com.uni.de.qvto.target.target.
2. Double click on this file, it will open target definition editor, wait for few minutes to load the target platform (Progress is shown at the right botton corner for loading the target). Once done, it will load all the components in an editor.
3. Click on Set Target platform button provided right top corner of target definition editor to set the platform definition.
4. Now, you will see projects in your navigator or project explorer without any errors.

##  Running the Product
1. QVTo Profiler product located in com.uni.de.qvto.mice.product
2. Run the product by using button "Launch an Eclipse Application" found when opening the product configuration editor
3. Browse the config.properties located in downloaded input files folder. 
4. Click on Tranform button.

![image](https://user-images.githubusercontent.com/40870815/114616595-584f5e00-9ca7-11eb-9d44-7b317a767daa.png)
