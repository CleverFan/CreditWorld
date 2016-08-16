// JavaScript Document

var base = {
	urlHead : "http://localhost:8080/CreditWorld/",
}
var user = {
	regist : function (){
		 $.ajax({
			type: 'POST',
			url : base.urlHead+"userRegist",
			async: true,
			//dataType : 'json',
			data : $('#userRegistForm').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				sessionStorage.loginName = json.loginName;
				var flag = json.flag;
				if(flag == "true") {
					alert('注册成功');
					window.location.href="personInput.html";
				} else {
					alert('表单保存失败');
				}
			}
		});
	},
	subInfo : function () {
		 $.ajax({
			type: 'POST',
			url : base.urlHead+"userDet?user.loginName="+sessionStorage.loginName,
			async: true,
			//dataType : 'json',
			data : $('#detInfo').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;
				if(flag == "true") {
					alert('提交成功');
					window.location.href="userShow.html";
				} else {
					alert('提交失败');
				}
			}
		});
	},
	login : function () {
		$.ajax({
			type: 'POST',
			url : base.urlHead+"userLogin",
			async: true,
			//dataType : 'json',
			data : $('.personLoginForm').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;
				sessionStorage.loginName = json.loginName;	
				if(flag == "true") {
					window.location.href="userShow.html";
				} else {
					alert('用户名或密码错误');
				}
			}
		});
	},
	getMsg : function (){
		$.ajax({
			type: 'POST',
			url : base.urlHead+"userGet?user.loginName="+sessionStorage.loginName,
			async: true,
			//dataType : 'json',
			data : {},
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;	
				if(flag == "true") {
					//{"userDet":{"backCount":"储蓄账户","credit":"商户贷记卡","creditBreak":"",
					//"creditTime":"","creditUse":"","debt":"15％～20％","house":"自有","liveTime":"0.5～2.49",
					//"mask":"119","occupation":"半人员","outCount":"","selectTime":"","userid":"1","workTime":"0.5～1.49"},
					//"flag":"true"}

					//设置各属性值
					$('.userMask').html("个人信用分:"+json.userDet.mask);
					
					var table = $('.person-register-content-table');
					$('<tr><td>住宅:</td><td>'+json.userDet.house+'</td></tr>').appendTo(table);
					$('<tr><td>现址居住年限:</td><td>'+json.userDet.liveTime+'</td></tr>').appendTo(table);
					$('<tr><td>职业:</td><td>'+json.userDet.occupation+'</td></tr>').appendTo(table);
					$('<tr><td>工作年限:</td><td>'+json.userDet.workTime+'</td></tr>').appendTo(table);
					$('<tr><td>信用卡情况:</td><td>'+json.userDet.credit+'</td></tr>').appendTo(table);
					$('<tr><td>银行帐户:</td><td>'+json.userDet.backCount+'</td></tr>').appendTo(table);
					$('<tr><td>债务比率:</td><td>'+json.userDet.debt+'</td></tr>').appendTo(table);
					$('<tr><td>一年内查询次数:</td><td>'+json.userDet.selectTime+'</td></tr>').appendTo(table);
					$('<tr><td>信用档案年限:</td><td>'+json.userDet.creditTime+'</td></tr>').appendTo(table);
					$('<tr><td>循环信用透支帐户个数:</td><td>'+json.userDet.outCount+'</td></tr>').appendTo(table);
					$('<tr><td>信用额度使用率:</td><td>'+json.userDet.creditUse+'</td></tr>').appendTo(table);
					$('<tr><td>毁誉记录:</td><td>'+json.userDet.creditBreak+'</td></tr>').appendTo(table);
				} else {
					alert('网络出错，暂未获得数据');
				}
			},
			error : function (request){
				alert("网络出错，暂未获得数据");
			}
		});
	}
}

var company = {
	regist : function () {
		$.ajax({
			type: 'POST',
			url : base.urlHead+"companyRegist",
			async: true,
			//dataType : 'json',
			data : $('#comBase').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				sessionStorage.cloginName = json.loginName;
				var flag = json.flag;
				if(flag == "true") {
					alert('注册成功');
					window.location.href="comInput.html";
				} else {
					alert('网络故障');
				}
			}
		});
	},
	subBase : function () {
		 $.ajax({
			type: 'POST',
			url : base.urlHead+"companyBase?company.loginName="+sessionStorage.cloginName,
			async: true,
			//dataType : 'json',
			data : $('#comBase').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;
				if(flag == "true") {
					alert('提交成功');
				} else {
					alert('提交失败');
				}
			}
		});
	},
	subDet : function () {
		$.ajax({
			type: 'POST',
			url : base.urlHead+"companyDet?company.loginName="+sessionStorage.cloginName,
			async: true,
			//dataType : 'json',
			data : $('#comDetToo').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;
				if(flag == "true") {
					alert('提交成功');
				} else {
					alert('提交失败');
				}
			}
		});
	},
	login : function () {
		$.ajax({
			type: 'POST',
			url : base.urlHead+"companyLogin",
			async: true,
			//dataType : 'json',
			data : $('.companyLoginForm').serialize(),
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;
				sessionStorage.cloginName = json.loginName;	
				if(flag == "true") {
					window.location.href="companyShow.html";
				} else {
					alert('用户名或密码错误');
				}
			}
		});
	},
	getMsg : function (){
		$.ajax({
			type: 'POST',
			url : base.urlHead+"companyGet?company.loginName="+sessionStorage.cloginName,
			async: true,
			//dataType : 'json',
			data : {},
			success : function(data){
				var json = JSON.parse(data);
				var flag = json.flag;	
				if(flag == "true") {

					//设置各属性值
					
					$('.companyMask').html("公司信用分:"+json.comDet.mask);
					
					var table = $('.company-register-content-table');
					$('<tr><td>中文名称:</td><td>'+json.comBase.cname+'</td></tr>').appendTo(table);
					$('<tr><td>英文名称:</td><td>'+json.comBase.ename+'</td></tr>').appendTo(table);
					$('<tr><td>注册地址:</td><td>'+json.comBase.raddress+'</td></tr>').appendTo(table);
					$('<tr><td>经营地址:</td><td>'+json.comBase.maddress+'</td></tr>').appendTo(table);
					$('<tr><td>经营面积:</td><td>'+json.comBase.marea+'</td></tr>').appendTo(table);
					$('<tr><td>场所产权性质:</td><td>'+json.comBase.csxz+'</td></tr>').appendTo(table);
					$('<tr><td>联系电话:</td><td>'+json.comBase.phone+'</td></tr>').appendTo(table);
					$('<tr><td>传真:</td><td>'+json.comBase.cz+'</td></tr>').appendTo(table);
					$('<tr><td>邮政编码:</td><td>'+json.comBase.yb+'</td></tr>').appendTo(table);
					$('<tr><td>网址:</td><td>'+json.comBase.wadd+'</td></tr>').appendTo(table);
					$('<tr><td>企业类型:</td><td>'+json.comBase.ctype+'</td></tr>').appendTo(table);
					$('<tr><td>注册号:</td><td>'+json.comBase.zch+'</td></tr>').appendTo(table);
					$('<tr><td>注册成立时间:</td><td>'+json.comBase.zctime+'</td></tr>').appendTo(table);
					$('<tr><td>贷款卡证号:</td><td>'+json.comBase.dkk+'</td></tr>').appendTo(table);
					$('<tr><td>组织机构代码:</td><td>'+json.comBase.zzjgdm+'</td></tr>').appendTo(table);
					
					$('<tr><td>连续经营时间:</td><td>'+json.comDet.lxtime+'</td></tr>').appendTo(table);
					$('<tr><td>注册资本:</td><td>'+json.comDet.zczb+'</td></tr>').appendTo(table);
					$('<tr><td>资产总额:</td><td>'+json.comDet.zcze+'</td></tr>').appendTo(table);
					$('<tr><td>经营场地:</td><td>'+json.comDet.jycd+'</td></tr>').appendTo(table);
					$('<tr><td>总经理管理岗位年限:</td><td>'+json.comDet.zjlglgwnx+'</td></tr>').appendTo(table);
					$('<tr><td>总经理学历:</td><td>'+json.comDet.zjlxl+'</td></tr>').appendTo(table);
					$('<tr><td>员工学历结构（大专及以上比例）:</td><td>'+json.comDet.ygxljg+'</td></tr>').appendTo(table);
					$('<tr><td>知识产权、专利保护数量:</td><td>'+json.comDet.zscqsl+'</td></tr>').appendTo(table);
					$('<tr><td>品牌价值:</td><td>'+json.comDet.ppjz+'</td></tr>').appendTo(table);
					$('<tr><td>机构设置的合理性:</td><td>'+json.comDet.jgszhlx+'</td></tr>').appendTo(table);
					$('<tr><td>质量管理体系认证:</td><td>'+json.comDet.zlrzgltx+'</td></tr>').appendTo(table);
					$('<tr><td>服务网点:</td><td>'+json.comDet.fwwd+'</td></tr>').appendTo(table);
					$('<tr><td>人力资源管理制度:</td><td>'+json.comDet.rlzygl+'</td></tr>').appendTo(table);
					$('<tr><td>人员考核:</td><td>'+json.comDet.rykh+'</td></tr>').appendTo(table);
					$('<tr><td>职业道德与诚信培训:</td><td>'+json.comDet.zzddpx+'</td></tr>').appendTo(table);
					$('<tr><td>客户管理制度建设:</td><td>'+json.comDet.khglzd+'</td></tr>').appendTo(table);
					$('<tr><td>合同管理:</td><td>'+json.comDet.htgl+'</td></tr>').appendTo(table);
					$('<tr><td>财务管理制度:</td><td>'+json.comDet.cwglzd+'</td></tr>').appendTo(table);
					$('<tr><td>资产负债率:</td><td>'+json.comDet.zcfzl+'</td></tr>').appendTo(table);
					$('<tr><td>资产负债率:</td><td>'+json.comDet.ldbl+'</td></tr>').appendTo(table);
					$('<tr><td>速动比率:</td><td>'+json.comDet.sdbl+'</td></tr>').appendTo(table);
					$('<tr><td>资产净利率:</td><td>'+json.comDet.zcjll+'</td></tr>').appendTo(table);
					$('<tr><td>净资产收益率:</td><td>'+json.comDet.jzcsyl+'</td></tr>').appendTo(table);
					$('<tr><td>销售净利率:</td><td>'+json.comDet.xsjll+'</td></tr>').appendTo(table);
					$('<tr><td>销售额增长率:</td><td>'+json.comDet.xsezzl+'</td></tr>').appendTo(table);
					$('<tr><td>总资产增长率:</td><td>'+json.comDet.zzczzl+'</td></tr>').appendTo(table);
					$('<tr><td>总资产增长率:</td><td>'+json.comDet.jzczzl+'</td></tr>').appendTo(table);
					$('<tr><td>净利润增长率:</td><td>'+json.comDet.jlrzzl+'</td></tr>').appendTo(table);
					$('<tr><td>现金流量充足率:</td><td>'+json.comDet.xjllczl+'</td></tr>').appendTo(table);
					$('<tr><td>现金流动负债比率:</td><td>'+json.comDet.xjldfzbl+'</td></tr>').appendTo(table);
					$('<tr><td>涉及企业的不良诉讼、仲裁记录:</td><td>'+json.comDet.sszcjl+'</td></tr>').appendTo(table);
					$('<tr><td>企业在公安、海关、工商、税务、商检、外汇、银行、劳保等部门的不良记录:</td><td>'+json.comDet.gabljl+'</td></tr>').appendTo(table);
					$('<tr><td>企业负责人获得嘉奖:</td><td>'+json.comDet.fzrjj+'</td></tr>').appendTo(table);
					$('<tr><td>企业负责人违规违法记录:</td><td>'+json.comDet.fzrwf+'</td></tr>').appendTo(table);
					$('<tr><td>企业获得行政机关或社团组织评定的荣誉记录:</td><td>'+json.comDet.qyry+'</td></tr>').appendTo(table);
					$('<tr><td>企业网站质量:</td><td>'+json.comDet.qywzzl+'</td></tr>').appendTo(table);
					$('<tr><td>电子商务交易:</td><td>'+json.comDet.dzswjy+'</td></tr>').appendTo(table);
					$('<tr><td>企业内部管理软件:</td><td>'+json.comDet.qyglrj+'</td></tr>').appendTo(table);

				} else {
					alert('网络出错，暂未获得数据');
				}
			},
			error : function (request){
				alert("网络出错，暂未获得数据");
			}
		});
	}
}