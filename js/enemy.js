function drawEnemies() {
	var canvas = document.getElementById('enemyLayer');
	var enemy = {x: window.screen.x - window.nyanImg.width + Math.floor(Math.random()*150), y: Math.floor(Math.random()*300)};
	window.enemies.push(enemy);
	moveEnemy(enemy, canvas.getContext('2d'));

	setTimeout(drawEnemies, window.popDelay);
}

function drawEnemy(enemy, ctx) {
	eraseEnemy(enemy, ctx);
	ctx.drawImage(window.nyanImg, enemy.x, enemy.y);
}

function eraseEnemy(enemy, ctx) {
	ctx.clearRect(enemy.x - 10, enemy.y, window.nyanImg.width + 10, window.nyanImg.height);
}

function moveEnemy(enemy, ctx) {
	enemy.x += window.enemyMoveSize;
	drawEnemy(enemy, ctx);
	if (enemy.x <= (window.screen.x + window.screen.width))
		setTimeout(function() { moveEnemy(enemy, ctx); }, window.enemyMoveSpeed);
}

function killEnemy(enemy) {
	var ctx = document.getElementById('enemyLayer').getContext('2d'),
		oldX = enemy.x  + window.nyanImg.width - 45;
	eraseEnemy(enemy, ctx);
	enemy.x += window.screen.width * 2;
	
	ctx.drawImage(window.deadNyanImg, oldX, enemy.y);
	setTimeout(function() {
		ctx.clearRect(oldX, enemy.y, window.deadNyanImg.width, window.deadNyanImg.height);
	}, window.deadDuration);
}

function hitboxCrossed(shoot) {
	return window.enemies.some(function(enemy) {
		if (intersectRect({left: shoot.x - 10, top: shoot.y - 30, right: shoot.x + 10, bottom: shoot.y},
						  {left: enemy.x + window.nyanImg.width - 45, top: enemy.y, right: enemy.x + window.nyanImg.width - 5, bottom: enemy.y + window.nyanImg.height})) {
			killEnemy(enemy);
			increaseScore();
			return true;
		}
	});
}