function init() {
	var canvas = document.getElementById('boardLayer');
	if (canvas.getContext) {
		// Background constants
		window.scrollingSpeed = 2;
		window.screen = {x: canvas.clientLeft, y: canvas.clientTop, width: canvas.clientWidth, height: canvas.clientHeight};
		
		// Plane constants
		window.planeMoveSize = 10;
		window.planeWidth = 50;
		window.planeHalfWidth = window.planeWidth / 2;
		window.planeHeight = 60;
		window.plane = {x: (window.screen.width / 2) - window.planeHalfWidth, y: (window.screen.height * 80 / 100)};
		
		// Shoots constants
		window.shootMoveSize = 30;
		window.shootSpeed = 50;
		
		// Enemies constants
		window.enemyMoveSize = 10;
		window.enemyMoveSpeed = 200;
		window.popDelay = 3000;
		window.minDelay = 500;
		window.deadDuration = 250;
		window.enemies = [];
		window.enemyValue = 10;
		
		// Events
		window.addEventListener('keydown', onKeyDown, true);
		
		// Images
		// TODO change the chained onload function to an image preloading system
		window.shootImg = new Image();
		window.shootImg.src = 'images/fire_1.jpg';
		window.shootImg.onload= function() {
			window.deadNyanImg = new Image();
			window.deadNyanImg.src = 'images/dead-nyan.png';
			window.deadNyanImg.onload= function() {
				window.nyanImg = new Image();
				window.nyanImg.src = 'images/nyan-cat.png';
				window.nyanImg.onload= function() {
					window.spaceImg = new Image();
					window.spaceImg.src = 'images/space_1.png';
					window.spaceImg.onload= function() {
						draw();
					}
				}
			}
		}
	}
}

function draw() {
	drawBackground(-window.spaceImg.height);
	drawBackground(0);
	drawPlane();
	drawEnemies();
}

function drawBackground(y) {
	var canvas = document.getElementById('boardLayer'),
		ctx = canvas.getContext('2d');
	
	if (y < (window.spaceImg.height - window.scrollingSpeed)) {
		ctx.save();
		ctx.drawImage(window.spaceImg, window.screen.x, y);
		setTimeout(function() { drawBackground(y + window.scrollingSpeed); }, 10);
		ctx.restore();
	} else {
		ctx.save();
		setTimeout(function() { drawBackground(-window.spaceImg.height); }, 10);
		ctx.restore();
	}
}

function increaseScore() {
	var scoreEl = document.getElementById('score'),
		score = Number(scoreEl.innerHTML);
	scoreEl.innerHTML = fillScore(score + window.enemyValue);
	increaseSpeed(window.enemyValue * 5);
}

function increaseSpeed(value) {
	if (window.popDelay > window.minDelay)
		window.popDelay -= value;
}

function fillScore(value) {
	var val = value.toString();
	while (val.length < 6) {
		val = '0' + val;
	}
	return val;
}