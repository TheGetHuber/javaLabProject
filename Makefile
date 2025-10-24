kill:
	@echo Killing Docker
	docker compose down --volumes

start:
	@echo Starting Docker
	docker compose up -d

restart:
	@echo "Restarting Docker"
	docker compose down --volumes
	docker compose up -d
