module.exports = {
	   transpileDependencies: ['vuetify']
    //, presets: [    '@vue/cli-plugin-babel/preset'  ]  // default code
    , outputDir: "../src/main/resources/static"
	, indexPath: "../static/index.html"
	, chainWebpack: config => {
		config.plugin('html').tap(args => {
			args[0].title = 'Board'
			return args
		})
		/*
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
	   */
	}
	, devServer: {
		  overlay: false
        , port : 9091   // 접속 포트 변경
        , proxy: "http://localhost:9090"     // devServer  :  Back-End , 즉 Spring Boot의 내장 was의 주소  * application.properties > server.port=9090
	}
};
