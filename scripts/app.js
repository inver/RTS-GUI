var Container = PIXI.Container,
    autoDetectRenderer = PIXI.autoDetectRenderer,
    loader = PIXI.loader,
    resources = PIXI.loader.resources,
    TextureCache = PIXI.utils.TextureCache,
    Texture = PIXI.Texture,
    Sprite = PIXI.Sprite;

var stage = new Container(),
    renderer = autoDetectRenderer(512, 512);
document.body.appendChild(renderer.view);

// loader.load(setup);

var createMariner = function (stage, radius) {
    var circle = Circle(stage, radius);
    var normal = HLine(0, radius, 2);

    normal.y = -1 + radius;
    normal.x = radius;

    var result = new PIXI.Container();

    stage.addChild(result);

    result.addChild(circle);
    result.addChild(normal);
    return result;
};

var HLine = function (from, to, thinkness, color) {
    var graphics = new PIXI.Graphics();

    graphics.beginFill(color || 0x00FF00);

    graphics.moveTo(from, 0);
    graphics.lineTo(to, 0);
    graphics.lineTo(to, thinkness);
    graphics.lineTo(from, thinkness);

    graphics.endFill();

    return graphics;
};

var Circle = function (stage, radius) {
    var p = new PIXI.Graphics();
    p.beginFill(0xFF0000);
    p.lineStyle(0);
    p.drawCircle(radius, radius, radius);
    p.endFill();

    var t = PIXI.RenderTexture.create(p.width, p.height);
    renderer.render(p, t);

    return new PIXI.Sprite(t);
};

function gameLoop() {

    requestAnimationFrame(gameLoop);
    updateState();

    renderer.render(stage);

}

var mariner = createMariner(stage, 10);

var pathRadius = 100;
var centerX = 200;
var centerY = 200;
var stepPerFrame = 1;

var x, y;

var tick = 0;

function updateState() {
    x = centerX + pathRadius * Math.cos(tick / 50);
    y = centerY + pathRadius * Math.sin(tick / 50);


    mariner.x = x;
    mariner.y = y;

    tick = tick + 1;
    console.log('x = ' + x + ', y = ' + y);
}

gameLoop();