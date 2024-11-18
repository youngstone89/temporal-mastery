.PHONY: build clean worker run

build:
	@mvn clean install -Dorg.slf4j.simpleLogger.defaultLogLevel=info 2>/dev/null

clean:
	@mvn clean -q -Dmaven.logging.level=0

worker:
	@mvn compile exec:java -Dexec.mainClass="moneytransfer.MoneyTransferWorker" -Dorg.slf4j.simpleLogger.defaultLogLevel=warn

run:
	@mvn compile exec:java -Dexec.mainClass="moneytransfer.TransferApp" -Dorg.slf4j.simpleLogger.defaultLogLevel=warn
