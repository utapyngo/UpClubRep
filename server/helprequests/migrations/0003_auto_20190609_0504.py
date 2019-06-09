# Generated by Django 2.2.2 on 2019-06-09 05:04

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('helprequests', '0002_helprequest_skill'),
    ]

    operations = [
        migrations.AddField(
            model_name='helprequest',
            name='lat',
            field=models.DecimalField(blank=True, decimal_places=3, max_digits=8, null=True),
        ),
        migrations.AddField(
            model_name='helprequest',
            name='lon',
            field=models.DecimalField(blank=True, decimal_places=3, max_digits=8, null=True),
        ),
    ]