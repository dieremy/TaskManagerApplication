build:
	@docker compose up -d --build --force-recreate

status:
	@git status

git:
	@git add .
	@git commit -m "$msg"
	@git push

clean:
	@docker compose down

fclean: clean
	@rm -rf .vscode .idea

re:
	@clean build

.PHONY: build clean re fclean git
