@set p=%CD%
@cd  %p%\client\
@start ng serve --open
@cd  %p%
@start gradlew bootRun