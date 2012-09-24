function drawPlane() {
	var wingWidth = 15;

	var minY = window.plane.y,
		minX = window.plane.x,
		midX = minX + window.planeHalfWidth,
		maxY = minY + window.planeHeight,
		maxX = midX + window.planeHalfWidth;

	var endWingY = minY + window.planeHeight - 10;
	
	var ctx = document.getElementById('planeLayer').getContext('2d');
	ctx.save();
	ctx.beginPath();
	ctx.moveTo(midX, minY);
	ctx.lineTo(minX, endWingY);
	ctx.lineTo(minX + wingWidth, endWingY);
	ctx.lineTo(midX, maxY);
	ctx.lineTo(maxX - wingWidth, endWingY);
	ctx.lineTo(maxX, endWingY);
	ctx.closePath();
	ctx.fillStyle="#FFFFFF";
	ctx.fill();
	
	ctx.beginPath();
	ctx.moveTo(midX, minY);
	ctx.lineTo(minX + wingWidth, endWingY);
	ctx.moveTo(maxX - wingWidth, endWingY);
	ctx.lineTo(midX, minY);
	ctx.lineTo(midX, maxY);
	ctx.stroke();
	ctx.restore();
}