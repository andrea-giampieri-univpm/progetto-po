<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Weather - Today's Forecast</title>
    <link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alata&amp;display=swap">
    <link rel="stylesheet" href="asset/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="asset/fonts/ionicons.min.css">
    <link rel="stylesheet" href="asset/css/Footer-Basic.css">
</head>

<body>
  <form action="/statistics" method="POST" modelAttribute="statistics">
    <div class="modal fade" role="dialog" tabindex="-1" id="statistics">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" style="background: var(--bs-blue);">
                    <h4 class="modal-title" style="font-weight: bold;color: rgb(255,255,255);">STATISTICS</h4><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p class="text-start" style="min-height: 48px;font-size: 19px;font-weight: bold;height: 50px;">Select data and time:</p>
                        <div style="height: 60px;">
                          <label class="form-label d-flex float-start" for="datafrom" style="margin-top: 6px;">From:</label>
                          <input class="form-control d-flex float-start" type="datetime-local" min="${fromDateMin}" max="${fromDateMax}" style="padding: 6px 12px;min-width: 130px;max-width: 225px;margin-left: 30px;margin-right: 10px;">
                        </div>
                        <div style="height: 60px;margin-top: 40px;">
                          <label class="form-label d-flex float-start" style="margin-top: 6px;">To:&nbsp; &nbsp; &nbsp;&nbsp;</label>
                          <input class="form-control d-flex float-start" type="datetime-local"  min="${toDateMin}" max="${toDateMax}" style="height: 38px;padding: 6px 12px;min-width: 130px;max-width: 225px;margin-left: 30px;margin-right: 10px;">
                        </div>
                </div>
                <div class="modal-footer"><button class="btn btn-light" type="button" data-bs-dismiss="modal" style="background: rgb(255,255,255);">Close</button><button class="btn btn-primary" type="submit">Submit</button></div>
            </div>
        </div>
    </div>
    </form>
    <header class="text-center masthead" style="font-size: 13px;padding-top: 50px;background: url(&quot;asset/img/background.jpg&quot;);background-size: cover;">
        <nav class="navbar navbar-light navbar-expand-md fixed-top">
            <div class="container-fluid"><a class="navbar-brand" href="#"><img src="asset/img/logo.png"></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1" style="width: 1000px;">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item" style="margin-top: 20px;"><a class="nav-link d-flex float-end" href="" style="font-size: 20px;font-family: Alata, sans-serif;font-weight: bold;color: rgb(0,0,0);height: 50px;">Home</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" style="color: rgb(0,0,0);background: #ffffff;border-style: solid;margin-top: 120px;">
            <div class="row">
                <div class="col-md-6" style="border-right-width: 1px;border-right-style: solid;">
                    <div class="row">
                        <div class="col">
                            <div class="row">
                                <div class="col" style="background: var(--bs-blue);border-color: var(--bs-blue);">
                                    <h1>${cityName}</h1>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col" style="margin-top: 10px;">
                                    <h2 style="text-align: left;">${cityId}</h2>
                                </div>
                                <div class="col" style="margin-top: 10px;">
                                    <h2>${country}</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="row">
                                <div class="col" style="margin-top: 50px;"><img class="d-inline-flex float-none" src="${weatherIcon}" style="width: 100px;">
                                    <h1 class="d-inline-flex float-end" style="width: 150px;margin-top: 18px;">${temp}&deg${units}</h1>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col" style="margin-top: 10px;">
                                    <h2 style="color: #fca311;">${description}</h2>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div style="height: 35px;"></div>
                            <p class="text-start" style="margin-left: 20px;">Temperature: ${temp}&deg${simbol}</p>
                            <p class="text-start" style="margin-left: 20px;">Pressure: ${pressure} hPA</p>
                            <p class="text-start" style="margin-left: 20px;">Humidity: ${humidity} %</p>
                            <p class="text-start" style="margin-left: 20px;">Cloudy: ${cloudy} %</p>
                            <p class="text-start" style="margin-left: 20px;">Wind: ${wind} m/s</p>
                            <p class="text-start" style="margin-left: 20px;">Rain: ${rain} mm/h</p>
                            <p class="text-start" style="margin-left: 20px;">Snow: ${snow} mm/h</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div style="height: 60px;"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" style="border-right-width: 1px;border-right-style: solid;border-left-width: 1.5px;border-left-style: solid;">
                    <div class="row">
                        <div class="col" style="background: var(--bs-blue);border-color: var(--bs-blue);">
                            <h1>STATISTICS</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col" style="margin-top: 10px;">
                            <h2 class="text-start">Range:&nbsp; &nbsp;date and time</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h3 style="margin-top: 25px;">Pressure</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col" style="margin-left: 20px;">
                            <p style="font-size: 20px;margin-top: 10px;color: rgb(214,24,24);">${error}sta</p>
                            <p style="margin-top: 5px;">MIN:    ${pressMin}  hPa</p>
                            <p>MAX:    ${pressMax}  hPa</p>
                            <p>AVERAGE:    ${presAverage}  hPa</p>
                            <p>VARIANCE:    ${pressVariance}  hPa</p>
                            <div style="height: 35px;"></div>
                        </div>
                    </div>
                    <div style="height: 50px;"><button class="btn btn-primary btn-lg d-flex float-end" type="button" data-bs-toggle="modal" data-bs-target="#statistics" style="height: 48px;margin-right: 20px;border-radius: 15px;border-style: solid;border-color: rgb(0,0,0);margin-bottom: 15px;">Get Statistics</button></div>
                </div>
            </div>
        </div>
    </header>
    <footer class="footer-basic" style="height: 130px;">
        <div class="container">
            <div class="row">
                <div class="col-md-6 d-flex float-end">
                    <ul class="list-inline" style="width: 100%;">
                        <li class="list-inline-item"><a href="">Home</a></li>
                    </ul>
                </div>
                <div class="col-md-6 d-flex float-start">
                    <p class="d-block copyright" style="height: 30px;width: 100%;margin-top: 6px;">&copyToday's Forecast 2022. All Rights Reserved.</p>
                </div>
            </div>
        </div>
        <div class="social" style="height: 100%;"><a href="https://github.com/andrea-giampieri-univpm/progetto-esame-po"><i class="icon ion-social-github"></i></a><a href="https://www.univpm.it/Entra"><i class="fa fa-university"></i></a></div>
    </footer>
    <script src="asset/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
