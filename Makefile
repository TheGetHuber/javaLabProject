killDocker:
	@echo "[MAKEFILE] Killing Docker."
	docker compose down --volumes > ./makeLogs/killDocker.log

startDocker:
	@echo "[MAKEFILE] Starting Docker."
	docker compose up -d > ./makeLogs/startDocker.log

restartDocker:
	@echo "[MAKEFILE] Restarting Docker."
	docker compose down --volumes > ./makeLogs/restartDocker_kill.log
	docker compose up -d > ./makeLogs/restartDocker_start.log

startProject:
	@echo "[MAKEFILE] Starting project."
	mvn -P 1C clean package
	#mvn spring-boot:run > ./makeLogs/startProject.log

buildProject:
	#@echo "[MAKEFILE] Building project."
	@echo "[MAKEFILE] TODO: Make something with it."
	#mvn spring-boot:build-image > ./makeLogs/buildProject.log
	#@echo "[MAKEFILE] Build successfull."

buildAndStart:
	$(MAKE) startDocker
	$(MAKE) buildProject
	$(MAKE) startProject
