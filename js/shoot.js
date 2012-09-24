function drawShoot(shoot, ctx) {
	var x = shoot.x,
		y = shoot.y;
	eraseShoot(shoot, ctx);
	ctx.save();
	
	ctx.beginPath();
	ctx.moveTo(x, y);
	ctx.quadraticCurveTo(x-2, y-16, x-5, y-20);
	ctx.bezierCurveTo(x-10, y-23, x-5, y-30 , x, y-30);
	ctx.bezierCurveTo(x, y-30, x+10, y-23 , x+5, y-20);
	ctx.quadraticCurveTo(x+2, y-16, x, y);
	
	ctx.fillStyle = ctx.createPattern(window.shootImg, 'repeat');
	ctx.fill();

	ctx.restore();
}

function eraseShoot(shoot, ctx, bb) {
	ctx.clearRect(shoot.x-7, shoot.y, 20, 30);
}

function moveShoot(shoot, ctx) {
	shoot.y -= window.shootMoveSize;
	drawShoot(shoot, ctx);
	checkHit(shoot, ctx);
	if ((shoot.y + window.shootImg.height) >= window.screen.y)
		setTimeout(function() { moveShoot(shoot, ctx); }, window.shootSpeed);
}

function checkHit(shoot, ctx) {
	if (hitboxCrossed(shoot)) {
		var st =""; //todo score
	}
}