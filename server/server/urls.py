"""server URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf import settings
from django.conf.urls import url
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import include
from django.urls import path
from django.views.generic import RedirectView
from rest_framework.authtoken.views import obtain_auth_token
from rest_framework.routers import DefaultRouter
from rest_framework.routers import SimpleRouter

from helprequests.api import HelpRequestViewSet
from patients.api import PatientViewSet
from reviews.api import ReviewViewSet
from skills.api import SkillViewSet
from users.api import UserViewSet
from volunteers.api import VolunteerViewSet

api = DefaultRouter() if settings.DEBUG else SimpleRouter()
api.register('user', UserViewSet)
api.register('volunteer', VolunteerViewSet)
api.register('patient', PatientViewSet)
api.register('review', ReviewViewSet)
api.register('skill', SkillViewSet)
api.register('help-request', HelpRequestViewSet)

urlpatterns = [
    url(r'^api-token-auth/', obtain_auth_token),
    url(r'^api/', include(api.urls)),
    url(r'^$', RedirectView.as_view(url='/admin')),
    path('admin/', admin.site.urls),
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
