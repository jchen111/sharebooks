package com.sharebooks.util.EmailTemplates

import groovy.text.StreamingTemplateEngine

/**
 * Created by z001ktb on 3/19/16.
 */
class UserCreatedEmailTemplate {

    FileWriter writer

    UserCreatedEmailTemplate(File file) {
        writer = new FileWriter(file)
    }

    void body(String name, String status, String url){

        def text = '''

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!--[if !mso]><!--><meta http-equiv="X-UA-Compatible" content="IE=edge"><!--<![endif]-->
    <meta name="viewport" content="width=device-width">
    <title> </title>
    <style type="text/css">
.wrapper a:hover {
  text-decoration: none !important;
}
.btn a:hover,
.footer__links a:hover {
  opacity: 0.8;
}
.wrapper .footer__share-button:hover {
  color: #ffffff !important;
  opacity: 0.8;
}
a[x-apple-data-detectors] {
  color: inherit !important;
  text-decoration: none !important;
  font-size: inherit !important;
  font-family: inherit !important;
  font-weight: inherit !important;
  line-height: inherit !important;
}
.column {
  padding: 0;
  text-align: left;
  vertical-align: top;
}
.mso .font-avenir,
.mso .font-cabin,
.mso .font-open-sans,
.mso .font-ubuntu {
  font-family: sans-serif !important;
}
.mso .font-bitter,
.mso .font-merriweather,
.mso .font-pt-serif {
  font-family: Georgia, serif !important;
}
.mso .font-lato,
.mso .font-roboto {
  font-family: Tahoma, sans-serif !important;
}
.mso .font-pt-sans {
  font-family: "Trebuchet MS", sans-serif !important;
}
.mso .footer p {
  margin: 0;
}
@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {
  .fblike {
    background-image: url(https://i7.createsend1.com/static/eb/master/13-the-blueprint-3/images/fblike@2x.png) !important;
  }
  .tweet {
    background-image: url(https://i8.createsend1.com/static/eb/master/13-the-blueprint-3/images/tweet@2x.png) !important;
  }
  .linkedinshare {
    background-image: url(https://i10.createsend1.com/static/eb/master/13-the-blueprint-3/images/lishare@2x.png) !important;
  }
  .forwardtoafriend {
    background-image: url(https://i9.createsend1.com/static/eb/master/13-the-blueprint-3/images/forward@2x.png) !important;
  }
}
@media only screen and (max-width: 620px) {
  .wrapper .size-18,
  .wrapper .size-20 {
    font-size: 17px !important;
    line-height: 26px !important;
  }
  .wrapper .size-22 {
    font-size: 18px !important;
    line-height: 26px !important;
  }
  .wrapper .size-24 {
    font-size: 20px !important;
    line-height: 28px !important;
  }
  .wrapper .size-26 {
    font-size: 22px !important;
    line-height: 31px !important;
  }
  .wrapper .size-28 {
    font-size: 24px !important;
    line-height: 32px !important;
  }
  .wrapper .size-30 {
    font-size: 26px !important;
    line-height: 34px !important;
  }
  .wrapper .size-32 {
    font-size: 28px !important;
    line-height: 36px !important;
  }
  .wrapper .size-34,
  .wrapper .size-36 {
    font-size: 30px !important;
    line-height: 38px !important;
  }
  .wrapper .size-40 {
    font-size: 32px !important;
    line-height: 40px !important;
  }
  .wrapper .size-44 {
    font-size: 34px !important;
    line-height: 43px !important;
  }
  .wrapper .size-48 {
    font-size: 36px !important;
    line-height: 43px !important;
  }
  .wrapper .size-56 {
    font-size: 40px !important;
    line-height: 47px !important;
  }
  .wrapper .size-64 {
    font-size: 44px !important;
    line-height: 50px !important;
  }
  .divider {
    Margin-left: auto !important;
    Margin-right: auto !important;
  }
  .btn a {
    display: block !important;
    font-size: 14px !important;
    line-height: 24px !important;
    padding: 12px 10px !important;
    width: auto !important;
  }
  .btn--shadow a {
    padding: 12px 10px 13px 10px !important;
  }
  .image img {
    height: auto;
    width: 100%;
  }
  .layout,
  .column,
  .preheader__webversion,
  .header td,
  .footer,
  .footer__left,
  .footer__right,
  .footer__inner {
    width: 320px !important;
  }
  .preheader__snippet,
  .layout__edges {
    display: none !important;
  }
  .preheader__webversion {
    text-align: center !important;
  }
  .header__logo {
    Margin-left: 20px;
    Margin-right: 20px;
  }
  .layout--full-width {
    width: 100% !important;
  }
  .layout--full-width tbody,
  .layout--full-width tr {
    display: table;
    Margin-left: auto;
    Margin-right: auto;
    width: 320px;
  }
  .column,
  .layout__gutter,
  .footer__left,
  .footer__right {
    display: block;
    Float: left;
  }
  .footer__inner {
    text-align: center;
  }
  .footer__links {
    Float: none;
    Margin-left: auto;
    Margin-right: auto;
  }
  .footer__right p,
  .footer__share-button {
    display: inline-block;
  }
  .layout__gutter {
    font-size: 20px;
    line-height: 20px;
  }
  .layout--no-gutter.layout--has-border:not(.layout--full-width),
  .layout--has-gutter.layout--has-border .column__background {
    width: 322px !important;
  }
  .layout--has-gutter.layout--has-border {
    left: -1px;
    position: relative;
  }
}
@media only screen and (max-width: 320px) {
  .border {
    display: none;
  }
  .layout--no-gutter.layout--has-border:not(.layout--full-width),
  .layout--has-gutter.layout--has-border .column__background {
    width: 320px !important;
  }
  .layout--has-gutter.layout--has-border {
    left: 0 !important;
  }
}
</style>

  <!--[if !mso]><!--><style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Ubuntu:400,700,400italic,700italic);
</style><link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700,400italic,700italic" rel="stylesheet" type="text/css"><!--<![endif]--><style type="text/css">
body,.wrapper{background-color:#f0f0f0}.wrapper h1{color:#565656;font-size:26px;line-height:34px}.wrapper h2{color:#565656;font-size:20px;line-height:28px}.wrapper h3{color:#565656;font-size:16px;line-height:24px}.wrapper a{color:#80bf2e}.wrapper a:hover{color:#496d1a !important}@media only screen and (max-width: 620px){.wrapper h1{}.wrapper h1{font-size:22px;line-height:31px}.wrapper h2{}.wrapper h2{font-size:17px;line-height:26px}.wrapper h3{}.wrapper p{}}.column,.column__background td{color:#787778;font-size:14px;line-height:21px}.column,.column__background td{font-family:Ubuntu,sans-serif}.mso .column,.mso .column__background td{font-family:sans-serif !important}.border{background-color:#bdbdbd}.layout--no-gutter.layout--has-border:not(.layout--full-width),.layout--has-gutter.layout--has-border .column__background,.layout--full-width.layout--has-border{border-top:1px solid
#bdbdbd;border-bottom:1px solid #bdbdbd}.wrapper blockquote{border-left:4px solid #bdbdbd}.divider{background-color:#bdbdbd}.wrapper .btn a{color:#fff}.wrapper .btn a{font-family:Ubuntu,sans-serif}.mso .wrapper .btn a{font-family:sans-serif !important}.wrapper .btn a:hover{color:#fff !important}.btn--flat a,.btn--shadow a,.btn--depth a{background-color:#80bf2e}.btn--ghost a{border:1px solid #80bf2e}.preheader--inline,.footer__left{color:#bdbdbd}.preheader--inline,.footer__left{font-family:Ubuntu,sans-serif}.mso .preheader--inline,.mso .footer__left{font-family:sans-serif !important}.wrapper .preheader--inline a,.wrapper .footer__left a{color:#bdbdbd}.wrapper .preheader--inline a:hover,.wrapper .footer__left a:hover{color:#bdbdbd !important}.header__logo{color:#c3ced9}.header__logo{font-family:Roboto,Tahoma,sans-serif}.mso .header__logo{font-family:Tahoma,sans-serif !important}.wrapper
.header__logo a{color:#c3ced9}.wrapper .header__logo a:hover{color:#859bb1 !important}.footer__share-button{background-color:#787878}.footer__share-button{font-family:Ubuntu,sans-serif}.mso .footer__share-button{font-family:sans-serif !important}.layout__separator--inline{font-size:20px;line-height:20px;mso-line-height-rule:exactly}
</style><meta name="robots" content="noindex,nofollow"></meta>
<meta property="og:title" content="adawdadqwedqwed"></meta>
</head>
<!--[if mso]>
  <body class="mso">
<![endif]-->
<!--[if !mso]><!-->
  <body class="full-padding" style="margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f0f0f0;">
<!--<![endif]-->
    <div class="wrapper" style="background-color: #f0f0f0;">
      <table style="border-collapse: collapse;table-layout: fixed;color: #bdbdbd;font-family: Ubuntu,sans-serif;" align="center">
        <tbody><tr>
          <td class="preheader__snippet" style="padding: 10px 0 5px 0;vertical-align: top;" width="300">

          </td>
          <td class="preheader__webversion" style="text-align: right;padding: 10px 0 5px 0;vertical-align: top;" width="300">

          </td>
        </tr>
      </tbody></table>
      <table class="header" style="border-collapse: collapse;table-layout: fixed;Margin-left: auto;Margin-right: auto;" align="center">
        <tbody><tr>
          <td style="padding: 0;" width="600">
            <div class="header__logo emb-logo-margin-box" style="font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #c3ced9;font-family: Roboto,Tahoma,sans-serif;">
              <div class="logo-center" style="font-size:0px !important;line-height:0 !important;" align="center" id="emb-email-header"><img style="height: auto;width: 100%;border: 0;max-width: 584px;" src="https://i1.createsend1.com/ei/i/60/30F/C12/153652/csfinal/literature-books-584.jpg" alt="" width="584" height="358"></div>
            </div>
          </td>
        </tr>
      </tbody></table>
      <table class="layout layout--no-gutter" style="border-collapse: collapse;table-layout: fixed;Margin-left: auto;Margin-right: auto;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;" align="center">
        <tbody><tr>
          <td class="column" style="padding: 0;text-align: left;vertical-align: top;color: #787778;font-size: 14px;line-height: 21px;font-family: Ubuntu,sans-serif;" width="600">

            <div style="Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;">
      <div style="line-height:20px;font-size:1px">&nbsp;</div>
    </div>

            <div style="Margin-left: 20px;Margin-right: 20px;">
      <h1 class="size-36" style="Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #565656;font-size: 36px;line-height: 43px;text-align: center;"><strong>Welcome to sharebooks!</strong></h1><p class="size-16" style="Margin-top: 20px;Margin-bottom: 20px;font-size: 16px;line-height: 24px;">&nbsp;<br>
Hi ${name}, thank you for joining us!&nbsp;Sharebooks dedicates to provide&nbsp;people a good platform to share their books as well as their knowledge, with your&nbsp;anticipation, let's make our share environment a better place!</p>
    </div>

            <div style="Margin-left: 20px;Margin-right: 20px;">
      <div style="line-height:10px;font-size:1px">&nbsp;</div>
    </div>

            <div style="Margin-left: 20px;Margin-right: 20px;Margin-bottom: 24px;">
      <div class="btn btn--depth" style="text-align:center;">
        <![if !mso]><a style="border-radius: 4px;display: inline-block;font-weight: bold;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #fff;border: 1px solid rgba(0, 0, 0, 0.25);box-shadow: inset 0 -3px 0 -1px rgba(0, 0, 0, 0.2), inset 0 2px 1px -1px #ffffff;text-shadow: 0 1px 0 rgba(0, 0, 0, 0.21);background-color: #2e98bf;font-family: Ubuntu, sans-serif;font-size: 14px;line-height: 24px;padding: 12px 35px;" href="http://qdqwdq.createsend1.com/t/i-l-hlikiyl-l-r/" data-width="146">Go to your home page</a><![endif]>
      <!--[if mso]><p style="line-height:0;margin:0;">&nbsp;</p><v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" href="http://qdqwdq.createsend1.com/t/i-l-hlikiyl-l-r/" style="width:218px" arcsize="8%" strokecolor="#22728F" filled="t"><v:fill type="gradient" angle="180" color="#2E98BF" color2="#2781A2"></v:fill><v:textbox style="mso-fit-shape-to-text:t" inset="0px,11px,0px,11px"><center style="font-size:14px;line-height:24px;color:#FFFFFF;font-family:sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px">Go to your home page</center></v:textbox></v:roundrect><![endif]--></div>
    </div>

          </td>
        </tr>
      </tbody></table>

      <div style="font-size: 10px;line-height: 10px;mso-line-height-rule: exactly;">&nbsp;</div>

      <table class="footer" style="border-collapse: collapse;table-layout: fixed;Margin-right: auto;Margin-left: auto;border-spacing: 0;" width="600" align="center">
        <tbody><tr>
          <td style="padding: 0 0 40px 0;">
            <table class="footer__right" style="border-collapse: collapse;table-layout: auto;border-spacing: 0;" align="right">
              <tbody><tr>
                <td class="footer__inner" style="padding: 0;">




                </td>
              </tr>
            </tbody></table>
            <table class="footer__left" style="border-collapse: collapse;table-layout: fixed;border-spacing: 0;color: #bdbdbd;font-family: Ubuntu,sans-serif;" width="400">
              <tbody><tr>
                <td class="footer__inner" style="padding: 0;font-size: 12px;line-height: 19px;">
                  <table class="footer__links emb-web-links" style="border-collapse: collapse;table-layout: fixed;"><tbody><tr>
                    </tr></tbody></table>
                  <div style="Margin-top: 26px;">
                    <div>ShareBooks</div>
                  </div>
                  <div class="footer__permission" style="Margin-top: 18px;">

                  </div>
                  <div>
                    <span><a style="text-decoration: underline;transition: opacity 0.1s ease-in;color: #bdbdbd;" href="http://qdqwdq.updatemyprofile.com/i-l-2AD73FFF-l-j" lang="en">Preferences</a>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a style="text-decoration: underline;transition: opacity 0.1s ease-in;color: #bdbdbd;" href="http://qdqwdq.createsend1.com/t/i-u-hlikiyl-l-d/">Unsubscribe</a>
                  </div>
                </td>
              </tr>
            </tbody></table>
          </td>
        </tr>
      </tbody></table>
      <img style="border: 0 !important;visibility: hidden !important;display: block !important;height: 1px !important;width: 1px !important;margin: 0 !important;padding: 0 !important;" src="https://qdqwdq.createsend1.com/t/i-o-hlikiyl-l/o.gif" width="1" height="1" border="0" alt=""><badge>
        <center class="badge" style="background-color:#d8d8d8" emb-template-badge>
          <div style="line-height:44px;mso-line-height-rule:exactly;">&nbsp;</div>
          <a style="text-decoration: underline;transition: opacity 0.1s ease-in;color: #80bf2e;" href="http://qdqwdq.createsend1.com/t/i-l-hlikiyl-l-y/">

            <img style="border: 0;" src="https://i7.createsend1.com/static/eb/master/13-the-blueprint-3/images/badge-dark.png" width="150" height="34" alt="Made with Campaign Monitor">
          </a>
          <div style="line-height:40px;mso-line-height-rule:exactly;">&nbsp;</div>
        </center>
      </badge>
    </div>

</body></html>



'''

        def template = new StreamingTemplateEngine().createTemplate(text)

        def binding = [
                name: name,
                url: url,
                status: status
        ]
        writer.write(template.make(binding))
        writer.close()
    }
}
