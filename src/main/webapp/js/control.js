function onKeyDown(e) {
	switch (e.keyCode) {
		case 32 :
			fire();
			break;
		case 37 :
			moveLeft();
			break;
		case 39 :
			moveRight();
			break;
	}
}

function fire() {
	var shoot = {x: window.plane.x + window.planeHalfWidth, y: window.plane.y + 2};
	moveShoot(shoot, document.getElementById('shootLayer').getContext('2d'));
}

function moveLeft() {
	var canvas = document.getElementById('planeLayer');
	
	if ((window.plane.x - window.planeMoveSize) >= (window.screen.x + 1)) {
		canvas.getContext('2d').clearRect(window.plane.x, window.plane.y, window.planeWidth+1, window.planeHeight);
		window.plane.x -= window.planeMoveSize;
		drawPlane();
	}
}

function moveRight() {
	var canvas = document.getElementById('planeLayer');
	
	if ((window.plane.x + window.planeWidth + window.planeMoveSize) <= (window.screen.width - 1)) {
		canvas.getContext('2d').clearRect(window.plane.x-1, window.plane.y, window.planeWidth+1, window.planeHeight);
		window.plane.x += window.planeMoveSize;
		drawPlane();
	}
}